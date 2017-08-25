package com.luzhishen.easypackage.facade.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CommandExecUtil {
    private static final Logger logger = LoggerFactory
            .getLogger(CommandExecUtil.class);
    private CommandExecUtil() {
    }

    public static class CmdExecResult extends BaseJavaBean {
        private int code;
        private String output = "";

        public boolean isSuccess() {
            return code == 0;
        }
    }

    @Nullable
    public static CmdExecResult execCmd(@NonNull String cmd, boolean needOutput) {
        logger.debug("cmd:{}", cmd);
        Process process = null;
        try {
            process = Runtime.getRuntime().exec("/bin/bash " + cmd);
            // .exec(new String[] { "/bin/bash", cmd });
            CmdExecResult result = new CmdExecResult();
            if (needOutput) {
                try (BufferedReader br = new BufferedReader(
                        new InputStreamReader(process.getInputStream()))) {
                    String line = null;
                    while ((line = br.readLine()) != null) {
                        result.output += line;
                    }
                    result.code = process.waitFor();
                } catch (InterruptedException e) {
                    logger.error("error occurred when executing cmd {}, {}", cmd, e);
                    return null;
                }
            }
            return result;
        } catch (IOException e) {
            logger.error("error occurred when executing cmd {}, {}", cmd, e);
            return null;
        } finally {
            process.destroy();
        }
    }

    public static void main(String... args) {
        System.out
                .println(execCmd(
                        "/home/rongzhisheng/work/EasyPackage-facade/src/main/shell/gitCheckoutAndPull.sh /home/rongzhisheng/workspace2/backyard/ master",
                        true));
    }
}
