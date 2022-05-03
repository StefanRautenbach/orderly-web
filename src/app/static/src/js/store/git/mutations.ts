import { MutationTree } from "vuex";
import { GitState } from "./git";
import { GitCommit, RunReportMetadata } from "../../utils/types";

export enum GitMutation {
    SetMetadata = "SetMetadata",
    SelectBranch = "SelectBranch",
    SetCommits = "SetCommits",
    SelectCommit = "SelectCommit"
}

export const mutations: MutationTree<GitState> = {
    [GitMutation.SetMetadata](state: GitState, payload: RunReportMetadata) {
        state.metadata = payload.metadata;
        state.branches = payload.git_branches;
        // if (state.branches.length && !state.branches.some(branch => branch === state.selectedBranch)) {
        //     state.selectedBranch = state.branches[0]
        // }
        // if (!state.branches.length) {
        //     state.selectedBranch = ""
        // }
    },
    [GitMutation.SelectBranch](state: GitState, payload: string) {
        state.selectedBranch = payload;
    },
    [GitMutation.SetCommits](state: GitState, payload: GitCommit[]) {
        state.commits = payload;
        if (state.commits.length && !state.commits.some(commit => commit.id === state.selectedCommit)) {
            console.log("should not fire", state.commits, state.selectedCommit, "after")
            state.selectedCommit = state.commits[0].id
        }
        if (!state.commits.length) {
            state.selectedCommit = ""
        }
    },
    [GitMutation.SelectCommit](state: GitState, payload: string) {
        state.selectedCommit = payload;
    }
}
