package com.luzhishen.easypackage.facade.biz;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.luzhishen.easypackage.facade.model.Commit;

@Service
public class GitBiz {

    public List<String> getBranchList(int platformId, int appId) {
        List<String> branchList = new ArrayList<>();
        branchList.add("master");
        branchList.add("debug");
        return branchList;
	}

    public List<Commit> getCommitList(int platformId, int appId,
            String branchName) {
        List<Commit> commitList = new ArrayList<>();
        commitList.add(new Commit());
        commitList.add(new Commit());
        return commitList;
	}

}