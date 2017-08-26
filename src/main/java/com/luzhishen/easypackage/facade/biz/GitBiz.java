package com.luzhishen.easypackage.facade.biz;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jdt.annotation.NonNull;
import org.springframework.stereotype.Service;

import com.luzhishen.easypackage.facade.constant.Constants;
import com.luzhishen.easypackage.facade.model.Commit;
import com.luzhishen.easypackage.facade.util.GitUtil;

@Service
public class GitBiz {
    @NonNull
    public List<String> getBranchList(int appId) {
        return GitUtil.getBranchList(Constants.Git.TEST_PROJECT_DIR);
	}

    public List<Commit> getCommitList(int platformId, int appId,
            String branchName) {
        List<Commit> commitList = new ArrayList<>();
        commitList.add(new Commit());
        commitList.add(new Commit());
        return commitList;
	}

}