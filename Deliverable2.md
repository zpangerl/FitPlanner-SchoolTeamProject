# Deliverable Information
   > Please include your answers below in a good format so it is easy for me to see. For answers to questions please use these Blockquotes. Make sure you also check the kickoff document for more details. Also make sure this thing is well formatted and the links are links in here. 

## 1: Basic Information (needed before you start with your Sprint -- Sprint Planning)

**Topic you chose:** Gym scheduling

**Sprint Number:** 2

**Scrum Master**: Steven Stovall

**Git Master**: Zachary Pangerl

### Sprint Planning (For Sprint 1-3)
Document your Sprint Planning here. Also check the kickoff document for more details on what needs to be done. This is just the documentation. 

**Sprint Goal:** Update FitPlanner to create gym classes and assign to rooms as well as add members (students/trainers) to the system.

**How many User Stories did you add to the Product Backlog:**  8

**How many User Stories did you add to this Sprint:** 8
> Answer the questions below about your Sprint Planning?

**Why did you add these US, why do you think you can get them done in the next Sprint?**

> We added the US that produce the most value to our customer. We chose the US with the least amount of dependencies to work in parallel among our team.

**Why do you think these fit well with your Sprint goal? (details)**

> These fit well with goal by implementing the new data and UI functionality to demonstrate the gym scheduler to the customer.

**Do you have a rough idea what you need to do? (if the answer is no then please let me know on Slack)**

> Yes. The team has already entered initial tasks to help get started.



## 2: During the Sprint
> Fill out the Meeting minutes during your Sprint and keep track of things. Update your Quality policies when needed, as explained in the lectures and in the Quality Policy documents on Canvas. 
I would also advise you to already fill out the Contributions section (End of sprint) as you go, to create less work at the end.

### Meeting minutes of your Daily Scrums (3 per week, should not take longer than 10 minutes):
> Add as many rows as needed and fill out the table. (Burndown starts with Sprint 2, and Continuous Integration starts with Sprint 3, not needed before that). 

| Date             | Who did NOT attend        | Meeting notes (very brief)                                                                 | Burndown Info (on track, ahead behind is enough) | GitHub Actions info (does the master pass) | Additional Info                                                                                                                |
|------------------|---------------------------|--------------------------------------------------------------------------------------------|--------------------------------------------------|--------------------------------------------|--------------------------------------------------------------------------------------------------------------------------------|
| 2023-11-05 (Sun) | None                      | US89 and US87 completed. Everyone at least has a Task in progress.                         | Behind                                           | n/a for Sprint 2                           |                                                                                                                                |
| 2023-11-08 (Wed) | None                      | Mostly no obstacles and appear to be moving past being stuck due to dependencies early on. | Behind                                           | n/a for Sprint 2                           | Team agreed to change standup frequency to daily after reviewing grading feedback to have more than 3 standups after Sprint 1. |
| 2023-11-09 (Thu) | None                      | No obstacles/blockers. Everyone has tasks in-progress.                                     | Behind                                           | n/a for Sprint 2                           |                                                                                                                                |
| 2023-11-10 (Fri) | Sean Mckeighan            | Good communication of obstacles and teamwork to resolve a blocking Task (GymClassList)     | Behind                                           | n/a for Sprint 2                           |                                                                                                                                |
| 2023-11-11 (Sat) | None                      | No obstacles (Rhett has workaround for Task99)                                             | Behind                                           | n/a for Sprint 2                           |                                                                                                                                |
| 2023-11-12 (Sun) | Frank Lin, Sean Mckeighan | Task99 blocking for Rhett. Zach delayed/blocked due to needing second reviewer for PR.     | Behind                                           | n/a for Sprint 2                           |                                                                                                                                |


## 3: After the Sprint

### Sprint Review
Answer as a team!

**Screen Cast link**: Your link

> Answer the following questions as a team. 

**What do you think is the value you created this Sprint?**

> The FitPlanner has the ability to add gym classes, students, trainers, and view classes by room.

**Do you think you worked enough and that you did what was expected of you?**

> As a team, we worked well on individual tasks and were responsive for tasks that were ready-to-test.

**Would you say you met the customers’ expectations? Why, why not?**

> Based on the goal aligned with the customer expectations, we delivered a product that shows progress toward the end goal.


### Sprint Retrospective

> Include your Sprint retrospective here and answer the following questions in an evidence based manner as a team (I do not want each of your individuals opinion here but the team perspective). By evidence-based manner it means I want a Yes or No on each of these questions, and for you to provide evidence for your answer. That is, don’t just say "Yes we did work at a consistent rate because we tried hard"; say "we worked at a consistent rate because here are the following tasks we completed per team member and the rate of commits in our Git logs."

**Did you meet your sprint goal?**

> Yes

**Did you complete all stories on your Spring Backlog?**

> No

**If not, what went wrong?**

> The tasks were ambitious, and the Java GUI code was more time-consuming than expected. We had a lot of US/Task dependencies that we could improve in the future to better define US/Tasks with fewer dependencies.

**Starting in Sprint 2**
Include a screenshot of your Burndown chart here and analyse in detail for me why it looks the way it does and how you could improve it if it needs improving. 

// TODO: upload screenshot and markdown to embed (discussed with screenshare)

> November 2-4: Good start and a couple 1 point tasks completed. <br> 5-7 chart flat due to dependencies <br> 8 huge drop in burndown due to at least two people completing difficult (high point) tasks on the same day <br> 9-12: steady progress with curve further increasing downward on the last day as the final work was completed.
> 

**Did you work at a consistent rate of speed, or velocity? (Meaning did you work during the whole Sprint or did you start working when the deadline approached.)**

> Yes, the overall trend is consistently decreasing. Although there were a couple with big jumps, they average out to consistent work.

**Did you deliver business value?**

> Yes, the software is able to help the gym electronically maintain a roster of students and trainers. The front desk owner will be able to quickly see the list of classes taking place in each room.

**Did you follow the Scrum process (e.g. move Tasks correctly?, keep the Taiga board up to date? work consistently?)**

> Yes, we followed the Scrum process, updated task comments during testing, and followed 1-2 task at a time rule.

**Are there things the team thinks it can do better in the next Sprint? (not needed for last Sprint)**

> Yes, better planning the tasks to have fewer dependencies. Making the User Stories a little less complex and adding additional smaller US if needed.

**How do you feel at this point? Get a pulse on the optimism of the team.**

> We are optimistic with a plan to take what we learned and do even better in Sprint 3.

### Contributions:

> In this section I want you to point me to your main contributions (each of you individually) for the current Sprint. Some of the below you will only need starting in later Sprints, I marked when they become important. 

Copy the section for each team member and then everyone adds their individual contributions. 

#### Steven Stovall

**Do you think you individually worked consistently and put in enough work into the project (give a short answer).
> Yes, active in Slack and try to help team as much as possible with code, collaboration, design, and kept Deliverable2.md up-to-date with each standup meeting. I had a plan based upon reverse engineering in Sprint 1 to implement a simple design by replacing memoranda code with simplified, clean code and was able to execute and deliver the Trainers data, UI, and persistent storage.

Below I want links that I can click on to your commit or PullRequest with your work (not the branch you worked on). I also want a short description what this commit/PR is about (or test etc.)

##### Links to GitHub commits (not PR) with main code contribution (up to 5 links) - important in each Sprint:

- [QualityPolicy.md](https://github.com/amehlhase316/Schnapsidee-Fall23B/commit/ea4b905b2952c5ee2f9e80dd47b39536b28f9b0e) - Updated QualityPolicy to add checklists
- [US86 Task117](https://github.com/amehlhase316/Schnapsidee-Fall23B/commit/c76ee0bb04372dbd59223f6fc6a8cbdf5cb28702) - Rewrite Trainer, simplify, and create compatible UI TrainersPanel to display table with rows of Trainers
- [US86 Task115](https://github.com/amehlhase316/Schnapsidee-Fall23B/commit/80dd23954715a2356ac100265d86d191220c8b13) - Implement the Add Trainer dialog
- [US133 Task135](https://github.com/amehlhase316/Schnapsidee-Fall23B/commit/a2d1f7b2313b06890d024dc0f35f1380fc57730c) - Persist TrainerList data when program open/closed
- [US86 Task117](https://github.com/amehlhase316/Schnapsidee-Fall23B/blame/US86-add_trainers_to_system/src/main/java/memoranda/TrainerList.java) - blame TrainerList due to show overall results of multiple small commits

##### Main contribution by file (Added sub-section by Steven Stovall, easier to show contributions than commits)
* Links to main code contributions (Unit Tests in unit test section)

- [US86 Trainer.java](https://github.com/amehlhase316/Schnapsidee-Fall23B/blame/dev/src/main/java/memoranda/Trainer.java)
- [US86 TrainerList.java](https://github.com/amehlhase316/Schnapsidee-Fall23B/blame/dev/src/main/java/memoranda/TrainerList.java)
- [US86 TrainerDialog.java](https://github.com/amehlhase316/Schnapsidee-Fall23B/blame/dev/src/main/java/memoranda/ui/TrainerDialog.java)
- [US86 TrainersPanel.java](https://github.com/amehlhase316/Schnapsidee-Fall23B/blame/dev/src/main/java/memoranda/ui/TrainersPanel.java)
- [US133 TrainerListFileStorage.java](https://github.com/amehlhase316/Schnapsidee-Fall23B/blame/US133-Persistent_Storage/src/main/java/memoranda/TrainerListFileStorage.java)

##### GitHub links to your Pull Requests (up to 3 links) -- fill out starting Sprint 1:

- [PR39 for US86](https://github.com/amehlhase316/Schnapsidee-Fall23B/pull/39)
- [PR40 US133 Task135](https://github.com/amehlhase316/Schnapsidee-Fall23B/pull/40)
- [PR41 Enable Github CI on master](https://github.com/amehlhase316/Schnapsidee-Fall23B/pull/41)

##### GitHub links to your Unit Tests (up to 3 links) -- fill out starting Sprint 3 (everyone should write 4 good Unit Tests each Sprint):
> Based on individual assignments, I thought some of these were supposed to start earlier than Sprint 3 and unsure if this is for on-campus or online schedule

- [TestWhiteBoxTrainer.java](https://github.com/amehlhase316/Schnapsidee-Fall23B/blame/US86-add_trainers_to_system/src/test/java/TestWhiteBoxTrainer.java) blame shows commits
- [TestTrainerListFileStorage.java](https://github.com/amehlhase316/Schnapsidee-Fall23B/blame/US133-Persistent_Storage/src/test/java/TestTrainerListFileStorage.java)


##### GitHub links to your Code Reviews (up to 3 links) -- fill out starting Sprint 3:
 > Based on individual assignments, I thought some of these were supposed to start earlier than Sprint 3 and unsure if this is for on-campus or online schedule

- [PR32 Review](https://github.com/amehlhase316/Schnapsidee-Fall23B/pull/32#pullrequestreview-1713820515)
- [PR33 Review](https://github.com/amehlhase316/Schnapsidee-Fall23B/pull/33#pullrequestreview-1713821561)
- [PR42 REview](https://github.com/amehlhase316/Schnapsidee-Fall23B/pull/42#pullrequestreview-1726253821)

##### How did you contribute to Static Analysis -- fill out starting Sprint 4:
> Based on individual assignments, I thought some of these were supposed to start earlier than Sprint 3 and unsure if this is for on-campus or online schedule

- [US86 branch pending dev](https://github.com/amehlhase316/Schnapsidee-Fall23B/blame/US86-add_trainers_to_system/build.gradle#L74-L83) - Configured Checkstyle to check relevant FitPlanner files
- [In process of enabling Github CI](https://github.com/amehlhase316/Schnapsidee-Fall23B/tree/configure_github_ci)

#### Rhett Harrison

**Do you think you individually worked consistently and put in enough work into the project (give a short answer).
I think I could have worked with others more to help get myself unblocked quicker.


Below I want links that I can click on to your commit or PullRequest with your work (not the branch you worked on). I also want a short description what this commit/PR is about (or test etc.)

Example:

**Links to GitHub commits (not PR) with main code contribution (up to 5 links) - important in each Sprint:

[Task 90, and some parts to help with task 99](https://github.com/amehlhase316/Schnapsidee-Fall23B/commit/e59ccf4542ece89f735058b4f01790e0b4d6bcd5)

[Task 141](https://github.com/amehlhase316/Schnapsidee-Fall23B/commit/0207c66d562e8b3a2fad6ce6ac25fc0be2ca4b8b)

**GitHub links to your Pull Requests (up to 3 links) -- fill out starting Sprint 1:

[Classes Panel with more checkstyle resolutions, other merge commits](https://github.com/amehlhase316/Schnapsidee-Fall23B/pull/47)

[Classes Panel, essentially the same as the one above](https://github.com/amehlhase316/Schnapsidee-Fall23B/pull/38)

**GitHub links to your Unit Tests (up to 3 links) -- fill out starting Sprint 3 (everyone should write 4 good Unit Tests each Sprint):

[GymClassListTest](https://github.com/amehlhase316/Schnapsidee-Fall23B/blob/rharrison/task90-create_class_panel/src/test/java/GymClassListTest.java)

**GitHub links to your Code Reviews (up to 3 links) -- fill out starting Sprint 3:

[Review 1](https://github.com/amehlhase316/Schnapsidee-Fall23B/pull/44)

[Review 2](https://github.com/amehlhase316/Schnapsidee-Fall23B/pull/39)


#### Frank Lin

**Do you think you individually worked consistently and put in enough work into the project (give a short answer).

> Absolutely, I believe I contributed consistently and put forth a solid effort towards the project. There's always room for growth and improvement, but my dedication and the work I've put in have been substantial and in line with the project's goals.

Below I want links that I can click on to your commit or PullRequest with your work (not the branch you worked on). I also want a short description what this commit/PR is about (or test etc.)

Example:
[Commit 1](https://github.com/amehlhase316/memoranda/commit/b949872433ae07f723bebe13c916064d03ef8882) - Updated DeliverableX.md table to include who did not attend meetings

**Links to GitHub commits (not PR) with main code contribution (up to 5 links) - important in each Sprint:

- [Implements the date selector on the new class dialog.](https://github.com/amehlhase316/Schnapsidee-Fall23B/commit/a4dfe180f9a3e3be5c7c9722e1ff38c4f36027aa) 
- [Imploements the class for gym class.](https://github.com/amehlhase316/Schnapsidee-Fall23B/commit/74d4169a438f006b1d4609515c74dee7b4b5e625)

**GitHub links to your Pull Requests (up to 3 links) -- fill out starting Sprint 1:

- [PR36 - Create the gym class class.](https://github.com/amehlhase316/Schnapsidee-Fall23B/pull/36)

**GitHub links to your Unit Tests (up to 3 links) -- fill out starting Sprint 3 (everyone should write 4 good Unit Tests each Sprint):

> N/A

**GitHub links to your Code Reviews (up to 3 links) -- fill out starting Sprint 3:

  - [Code review for PR#39.](https://github.com/amehlhase316/Schnapsidee-Fall23B/pull/39)

**How did you contribute to Static Analysis -- fill out starting Sprint 4:

> N/A

#### Zachary Pangerl

**Do you think you individually worked consistently and put in enough work into the project (give a short answer).
I think I did for the most part, there were a few days in the middle where I was unable to work due to my job schedule, but other than that I feel like I worked consistently

Below I want links that I can click on to your commit or PullRequest with your work (not the branch you worked on). I also want a short description what this commit/PR is about (or test etc.)

Example:
[Commit 1](https://github.com/amehlhase316/memoranda/commit/b949872433ae07f723bebe13c916064d03ef8882) - Updated DeliverableX.md table to include who did not attend meetings

**Links to GitHub commits (not PR) with main code contribution (up to 5 links) - important in each Sprint:

    - [Commit 1](https://github.com/amehlhase316/Schnapsidee-Fall23B/commit/9d36929816b09cdde08feabce71b7a4423d6a523)
    - [Commit 2](https://github.com/amehlhase316/Schnapsidee-Fall23B/commit/4e7a55552d83f9c93c19a930c5d9eedeab3930d0)
    - [Commit 3](https://github.com/amehlhase316/Schnapsidee-Fall23B/commit/705718dab7f8d34af4010dcfef2f6e0d7b39d9d4)

**GitHub links to your Pull Requests (up to 3 links) -- fill out starting Sprint 1:

    - [PR 1 - Add belt ranks](https://github.com/amehlhase316/Schnapsidee-Fall23B/pull/32)
    - [PR 2 - Add rooms](https://github.com/amehlhase316/Schnapsidee-Fall23B/pull/33)
    - [PR 3 - Add RoomsPanel to FitPlanner](<TODO>)

**GitHub links to your Unit Tests (up to 3 links) -- fill out starting Sprint 3 (everyone should write 4 good Unit Tests each Sprint):

    - [GymClassTest](https://github.com/amehlhase316/Schnapsidee-Fall23B/blob/dev/src/test/java/GymClassTest.java)
    - [RoomTest](https://github.com/amehlhase316/Schnapsidee-Fall23B/blob/dev/src/test/java/RoomTest.java)
    - [TestBeltRank - Steven did the last test case](https://github.com/amehlhase316/Schnapsidee-Fall23B/blob/dev/src/test/java/TestBeltRank.java)


**GitHub links to your Code Reviews (up to 3 links) -- fill out starting Sprint 3:

    - [Review 1](https://github.com/amehlhase316/Schnapsidee-Fall23B/pull/42)
    - [Review 2](https://github.com/amehlhase316/Schnapsidee-Fall23B/pull/34)
    - [Review 3](https://github.com/amehlhase316/Schnapsidee-Fall23B/pull/47)

**How did you contribute to Static Analysis -- fill out starting Sprint 4:

    - link1
    - link2

#### Sean Mckeighan

**Do you think you individually worked consistently and put in enough work into the project (give a short answer).
- Yes, I consistently worked on tasks assigned, teammates tasks ready for test, and pull request reviews. 

Below I want links that I can click on to your commit or PullRequest with your work (not the branch you worked on). I also want a short description what this commit/PR is about (or test etc.)

**Links to GitHub commits (not PR) with main code contribution (up to 5 links) - important in each Sprint:
- [Commit 1](https://github.com/amehlhase316/Schnapsidee-Fall23B/commit/1bb971a4096788b1f86adcfffc538c1da941fd18) - Implemented Student class.
- [Commit 2](https://github.com/amehlhase316/Schnapsidee-Fall23B/commit/774a5d1929442ecac82103062ca2baf99bdb9661) - Implemented Student class unit tests.
- [Commit 3](https://github.com/amehlhase316/Schnapsidee-Fall23B/commit/527ce53d76b0af961ad41c07570f43c5c4d8851f) - Implemented Student add dialog class.
- [Commit 4](https://github.com/amehlhase316/Schnapsidee-Fall23B/commit/f38551f60e314b0f5b2fe30cddef440f67839b4d) - Implemented StudentList class.
- [Commit 5](https://github.com/amehlhase316/Schnapsidee-Fall23B/commit/79b79ed08bac0c4fd2f197cfdcab7f56ef80c4e3) - Added Student icon to workpanel for navigation to Student Panel.

**GitHub links to your Pull Requests (up to 3 links) -- fill out starting Sprint 1:

- [PR 1](https://github.com/amehlhase316/Schnapsidee-Fall23B/commit/1bb971a4096788b1f86adcfffc538c1da941fd18) - I was the only teammate working on this branch. Only needed the PR to dev once US was complete.

**GitHub links to your Unit Tests (up to 3 links) -- fill out starting Sprint 3 (everyone should write 4 good Unit Tests each Sprint):

    - link1
    - link2

**GitHub links to your Code Reviews (up to 3 links) -- fill out starting Sprint 3:

    - link1
    - link2

**How did you contribute to Static Analysis -- fill out starting Sprint 4:

    - link1
    - link2
 
  

## Below is just for you as a little reminder on what needs to be done
### Checklist for you to see if you are done with the current Sprint
- [ ] Form above is complete - (Steven: TODO - don't forget embed burn)
- [ ] Your newest software is on the master branch on GitHub, it is tested and compiles/runs
- [ ] This document is in your master branch on GitHub
- [ ] Read the kickoff again to make sure you have all the details that I want
- [ ] User Stories that were not completed, were left in the Sprint and a copy created to move to the next Sprint
- [x] Your Quality Policies are accurate and up to date
- [ ] **Individual** Survey was submitted **individually** (create checkboxes below -- see Canvas to get link)
    - [ ] Rhett Harrison
    - [ ] Frank Lin
    - [ ] Steven Stovall
    - [ ] Zachary Pangerl
    - [x] Sean Mckeighan

#### For the next Sprint
  - [ ] The original of this file was copied for the next Sprint (needed for all but last Sprint where you do not need to copy it anymore)
    - [ ] Basic information (part 1) for next Sprint was included in this new Deliverable document 
  - [ ] You added new User Stories to your Product Backlog, they are correctly written (needed after Sprint 1, 2)
  - [ ] All User Stories have acceptance tests
  - [ ] User Stories in your new Sprint Backlog have initial tasks which are in New column
  - [ ] You know how to proceed (if not please reach out)
