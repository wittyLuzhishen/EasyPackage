package com.luzhishen.easypackage.facade.util;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.tuple.Pair;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.api.errors.GitAPIException;
import org.eclipse.jgit.lib.Ref;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.luzhishen.easypackage.facade.constant.Constants;
import com.luzhishen.easypackage.facade.util.CommandExecUtil.CmdExecResult;

public class GitUtil {
    private static final Logger logger = LoggerFactory.getLogger(GitUtil.class);
    private static final int START_INDEX = "refs/heads/".length();

    private GitUtil() {
    }

    private static Pair<Boolean, Path> isFileExist(@NonNull String file) {
        Path path = Paths.get(file);
        if (!Files.exists(path, LinkOption.NOFOLLOW_LINKS)) {
            logger.error("{} not exist", file);
            return Pair.of(false, path);
        }
        return Pair.of(true, path);
    }

    @NonNull
    public static List<String> getBranchList(@NonNull String projectRootDir) {
        List<String> branchList = new ArrayList<>();
        Pair<Boolean, Path> fileExist = isFileExist(projectRootDir);
        if (!fileExist.getLeft()) {
            return branchList;
        }
        try (Git git = Git.open(fileExist.getRight().toFile())) {
            git.fetch().call();
            List<Ref> refList = git.branchList().call();
            for (Ref ref : refList) {
                branchList.add(ref.getName().substring(START_INDEX));
            }
        } catch (GitAPIException e) {
            logger.error("git error, {}", e);
        } catch (IOException e) {
            logger.error("project dir error, {}", e);
        }
        return branchList;
    }

    public static void checkoutAndPull(@NonNull String projectRootDir,
            @NonNull String branchOrCommit) {
        Pair<Boolean, Path> fileExist = isFileExist(projectRootDir);
        if (!fileExist.getLeft()) {
            return;
        }
        File file = fileExist.getRight().toFile();
        try (Git git = Git.open(file)) {
            CmdExecResult result = CommandExecUtil.execCmd(
                    Constants.TOMCAT_PATH
                            + "/webapps"
                            + Config.getContextPath()
                            + "/shell/gitCheckoutAndPull.sh "
                            + file.getAbsolutePath()
                            + " "
                            + branchOrCommit, true);
            if (result == null || !result.isSuccess()) {
                logger.error("checkout failed, {}", result);
            }
        } catch (IOException e) {
            logger.error("error occurred, {}", e);
        }
    }

    public static void main(String... args) {
        String dir = "/home/rongzhisheng/AndroidStudioProjects/walilive";
        long startTime = System.currentTimeMillis();
        List<String> branchList = getBranchList(dir);
        System.out.println(branchList);

        System.out.println(System.currentTimeMillis() - startTime);
    }
}
