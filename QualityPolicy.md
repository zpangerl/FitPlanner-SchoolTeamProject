### Quality Policy
> Describe your Quality Policy in detail for this Sprint (remember what I ask you to do when I talk about the "In your Project" part in the lectures and what is mentioned after each assignment (in due course you will need to fill out all of them, check which ones are needed for each Deliverable). You should keep adding things to this file and adjusting your policy as you go.
> Check in Project: Module Concepts document on Canvas in the Project module for more details 

**GitHub Workflow** (start Sprint 1)
  > Commit messages
  >  - ALL commits must include US# and Task# (replace # with appropriate number)
  >  - It is okay to include "WIP" to save/commit work when not fully completed
  >  - Use imperative mood, capitalize the subject, and do not end subject line with a period

  > Branch names
  >  - `US#-a_short_description` (replace # with appropriate number) (`_` instead of spaces to remove need to escape space characters)
  >  - `Task#-a_short_description` (replace # with appropriate number) (`_` instead of spaces to remove need to escape space characters)
  >  - NOTE: hyphen after the number for US and Task branch names

  > Maintain dev branch
  >  - No commits directly to dev without pull request
  >  - Only pull request to merge from US branches to dev
  >  - All pull requests should be fast-forwards only (merge latest dev branch to US story so that it is fast-forward)
  >  - Two reviewers to merge to dev
  >  - Only git master completes merge pull request via Github "Squash and merge" to ensure fast-forward

  > Maintain master branch
  >  - pull request from dev to master
  >  - Two reviewers to merge from dev to master
  >  - Only git master completes merge pull request via Github "Squash and merge" to ensure fast-forward

  > `deliverableN-documentation` branch
  >  - During Sprint, update Deliverable#.md (where # is the Sprint number) via the `deliverable#` branch
  >  - Updates will be merged to dev branch via pull request as described in above section "Maintain dev branch"
  >  - Also includes items such as `QualityPolicy.md` and `ProjectKickoffChecklist.md`

  > NOTE: Github "Squash and merge" option to ensure fast-forward
  >  - https://docs.github.com/en/pull-requests/collaborating-with-pull-requests/incorporating-changes-from-a-pull-request/about-pull-request-merges#squash-and-merge-your-commits


**Unit Tests Blackbox** (start Sprint 2)
  > Your Blackbox testing policy 

 **Unit Tests Whitebox** (online: start Sprint 2, campus: start Sprint 3)
  > Your Whitebox testing policy 

**Code Review** (online: due start Sprint 2, campus: start Sprint 2)
  > Your Code Review policy for on campus it is ok to have a less formal process in Sprint 2, should be updated in Sprint 3 though

  > Include a checklist/questions list which every developer will need to fill out/answe when creating a Pull Request to the Dev branch. 

  > Include a checklist/question list which every reviewer will need to fill out/anser when conducting a review, this checklist (and the answers of course) need to be put into the Pull Request review.

**Static Analysis**  (online: start Sprint 3, campus: start Sprint 3)
  > Your Static Analysis policy   

**Continuous Integration**  (start Sprint 3, campus: start Sprint 3)
  > Your Continuous Integration policy
