### Quality Policy
> Describe your Quality Policy in detail for this Sprint (remember what I ask you to do when I talk about the "In your Project" part in the lectures and what is mentioned after each assignment (in due course you will need to fill out all of them, check which ones are needed for each Deliverable). You should keep adding things to this file and adjusting your policy as you go.
> Check in Project: Module Concepts document on Canvas in the Project module for more details 

**GitHub Workflow** (start Sprint 1)
  > Commit messages
  >  - ALL commits must include US# and Task# (replace # with appropriate number)
  >  - It is okay to include "WIP" to save/commit work when not fully completed
  >  - Use imperative mood, capitalize the subject, and do not end subject line with a period
  >  - Unit Tests: `US# Task# Unit Test: <description>` (replace # with appropriate number)

  > Branch names
  >  - `US#-a_short_description` (replace # with appropriate number) (`_` instead of spaces to remove need to escape space characters)
  >  - `Task#-a_short_description` (replace # with appropriate number) (`_` instead of spaces to remove need to escape space characters)
  >  - NOTE: hyphen after the number for US and Task branch names

  > Maintain US and Task branches
  >  - To avoid merge conflicts, consider US dependencies to avoid the need to merge from other US branches not pulled to dev

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
  >  - gradle should be configured as team to use junit:4.12 (gradle) with unit tests in `src/test/java/`
  >  - Blackbox testing policy
  >  - Areas to test? Focus on FitPlanner specific code implemented as part of Task or US but open to test other memoranda code or code from peers to meet the unit test requirement (e.g. if working on UI and need something else to test)
  >  - Who will test? Follow Developer and Reviewer checklist so that tests are verified by both.
  >  - How will you test? Equivalence Partitions are most likely for FitPlanner due to features being valid/invalid. Boundary Value Analysis may make sense if we get to weight class features by the end of Sprint 3.

```
Add unit test to ensure some or all of the User Story or task(s) work as expected.

Higher level abstraction that may touch multiple methods and parts of the code.
```
 **Unit Tests Whitebox** (online: start Sprint 2, campus: start Sprint 3)
  >  - Your Whitebox testing policy
  >  - Tool? Configure build.gradle for Jacoco (Frankie is adding Jacoco as part of his PR)
  >  - Areas to test? Focus on FitPlanner specific code implemented as part of Task or US but open to test other memoranda code or code from peers to meet the unit test requirement (e.g. if working on UI and need something else to test)
  >  - Criteria? `gradle jacocoTestReport` - Developer should review to target at least 80% coverage for FitPlanner code added/modified
  >  - Who will test? Follow Developer and Reviewer checklist so that tests are verified by both.
```
Add unit test to ensure new methods added work as described and return expected value
```
**Code Review** (online: due start Sprint 2, campus: start Sprint 2)
  > Developer Checklist. Must be included as part of pull request. Copy/paste and complete checklist below

```
 - [ ] Code compiles and runs (`gradle run`)
 - [ ] After latest dev merged to branch, ensure existing and new unit tests still passing
 - [ ] Code includes javadoc with short description of methods, parameters, return value
 - [ ] Unused imports have been removed
 - [ ] Code includes unit tests
 - [ ] 0 Checkstyle errors for created/modified code
 - [ ] 0 SpotBugs errors for created/modified code
```

  >  - Reviewer Checklist. Must be included in the Github Pull Request Review when you complete a review and approve.
  >  - Add additional comments as needed. Copy/paste and complete checklist below

```
 - [ ] Unit tests are present and correct
 - [ ] Comments and javadoc add value and are not too short or too long
 - [ ] Ensure that branch with PR has latest dev merged prior to merging to dev
 - [ ] Verify CI builds pass
```

**Static Analysis**  (online: start Sprint 3, campus: start Sprint 3)
  > 0 Checkstyle errors for code that you create or modify<br>
  > 0 SpotBugs errors for code that you create or modify

**Continuous Integration**  (start Sprint 3, campus: start Sprint 3)
  > Can only merge if CI passes(both dev and master)
