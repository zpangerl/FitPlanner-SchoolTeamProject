# Deliverable Information
   > Please include your answers below in a good format so it is easy for me to see. For answers to questions please use these Blockquotes. Make sure you also check the kickoff document for more details. Also make sure this thing is well formatted and the links are links in here. 

## 1: Basic Information (needed before you start with your Sprint -- Sprint Planning)

**Topic you chose:** Gym scheduling

**Sprint Number:** 1

**Scrum Master**: Frank Lin

**Git Master**: Rhett Harrison

### Sprint Planning (For Sprint 1-3)
Document your Sprint Planning here. Also check the kickoff document for more details on what needs to be done. This is just the documentation. 

**Sprint Goal:** Change the memerada application interface to align with a gym scheduling system. 

**How many User Stories did you add to the Product Backlog:**  4

**How many User Stories did you add to this Sprint:** 
> 10

**Why did you add these US, why do you think you can get them done in the next Sprint?**

> We want to fix the existing code base to remove obvious bugs and gain an understanding of the code base. We also want to add some basic features to the code base so the program will start resembling a functioning gym management system.

**Why do you think these fit well with your Sprint goal? (details)**

> By making sure the correct language and icons are displayed, we can make sure the user is able to understand the program. In order for the program to be useful, the application needs to run without errors and crashing. To make the changes mentioned above, we need to understand the code base and how it works through reverse engineering.

**Do you have a rough idea what you need to do? (if the answer is no then please let me know on Slack)**

> Yes, we will be updating the code base to make sure the correct language and icons are displayed. We will also be fixing the code base to make sure the program runs without errors and crashing. 


## 2: During the Sprint
> Fill out the Meeting minutes during your Sprint and keep track of things. Update your Quality policies when needed, as explained in the lectures and in the Quality Policy documents on Canvas. 
I would also advise you to already fill out the Contributions section (End of sprint) as you go, to create less work at the end.

### Meeting minutes of your Daily Scrums (3 per week, should not take longer than 10 minutes):
> Add as many rows as needed and fill out the table. (Burndown starts with Sprint 2, and Continuous Integration starts with Sprint 3, not needed before that). 

| Date    | Who did NOT attend             | Meeting notes (very brief)                                                                                                                             | Burndown Info (on track, ahead behind is enough) | GitHub Actions info (does the master pass) | Additional Info |
| ------- | ------------------------------ | ------------------------------------------------------------------------------------------------------------------------------------------------------ | ------------------------------------------------ | ------------------------------------------ | --------------- |
| Oct. 23 | Sean Mckeighan (Late by 1 day) | US11, 18 are completed. Some tasks from US11, 19 are complete.                                                                                         | On track                                         | No merge conflicts on PRs                  | None            |
| Oct. 25 | None                           | Trainer panel is under active dev. Some tasks from US1 are complete. US5, 6, 10, 19 is complete. First draft for Agenda Panel UML diagram is complete. | On track                                         | No merge conflicts on PRs                  | None            |
| Oct. 27 | Sean Mckeighan (Late by 1 day) | Most members are working on code reviews. PRs are being merged and any conflicts are being resolved. UML document is complete.                         | On track                                         | All merge conflects resolved               | None            |


## 3: After the Sprint

### Sprint Review
Answer as a team!

**Screen Cast link**: https://www.youtube.com/watch?v=vFjA_tPRLCc

> Answer the following questions as a team. 

**What do you think is the value you created this Sprint?**

> We delivered value by updating the Memoranda interface to align with a gym scheduling tool. Multiple warnings were removed, and the dev team has a better understanding to more efficiently add additional features in the future sprints for the customer.

**Do you think you worked enough and that you did what was expected of you?**

> Yes, we worked through challenges of onboarding with a new codebase and were able to complete all User Stories for this Sprint.

**Would you say you met the customers’ expectations? Why, why not?**

> Yes, the customers' expectations should be met because it is obvious the software UI has changed from Memoranda to "Fit Planner" with updated splash screen, icons, and the beginning implementation of specific customer requirements such adding and displaying Trainers.


### Sprint Retrospective

> Include your Sprint retrospective here and answer the following questions in an evidence based manner as a team (I do not want each of your individuals opinion here but the team perspective). By evidence-based manner it means I want a Yes or No on each of these questions, and for you to provide evidence for your answer. That is, don’t just say "Yes we did work at a consistent rate because we tried hard"; say "we worked at a consistent rate because here are the following tasks we completed per team member and the rate of commits in our Git logs."

**Did you meet your sprint goal?**

> Yes, we met our sprint goal by modifying the memoranda code base to architect a gym scheduling application.

**Did you complete all stories on your Spring Backlog?**

> Yes, we completed all stories that were part of the Sprint 1 backlog--User Stories 11, 18, 5, 6, 19, 9, 10, 1, 2, and 15.

**If not, what went wrong?**

> Your Answer

**Starting in Sprint 2**
Include a screenshot of your Burndown chart here and analyse in detail for me why it looks the way it does and how you could improve it if it needs improving. 

> Your Answer

**Did you work at a consistent rate of speed, or velocity? (Meaning did you work during the whole Sprint or did you start working when the deadline approached.)**

> We started with a lot of velocity, slowed down during the middle of the week while we streamlined the testing and Github review process, then increased velocity to ensure everything was completed by end of the Sprint.

**Did you deliver business value?**

> Value was delivered through updates that changed the Memoranda app drastically to reflect the customers' expectations so that by end of the week, the UI reflects a gym scheduler with English language, icons for a gym scheduler, and a skeleton interface for Trainers to be added in the future.

**Did you follow the Scrum process (e.g. move Tasks correctly?, keep the Taiga board up to date? work consistently?)**

> Yes, overall we moved the tasks through the stages from New, In-progress, ready-for-test, and to closed. At first, we had too many tasks pile up in "ready for test" and had to improve communication to clear the board from "ready for test" to "closed".

**Are there things the team thinks it can do better in the next Sprint? (not needed for last Sprint)**

> We could improve the process to make sure the entire team understands the expectations of level of detail needed in Taiga tasks when getting from "ready for test" to "closed" along with getting the respective Github pull request opened, reviewed, merged, and closed. 

**How do you feel at this point? Get a pulse on the optimism of the team.**

> The team has an optimal outlook on Sprint 2 and is ready for additional tasking.

### Contributions:

> In this section I want you to point me to your main contributions (each of you individually) for the current Sprint. Some of the below you will only need starting in later Sprints, I marked when they become important. 

Copy the section for each team member and then everyone adds their individual contributions. 

#### Steven Stovall

  **Do you think you individually worked consistently and put in enough work into the project (give a short answer). 

  > Yes, I was engaged in Slack discussion, standups, contributed to Tasks and US, participated in [github reviews: US15, US5, US19, US10](https://github.com/amehlhase316/Schnapsidee-Fall23B/pulls?q=is%3Apr+is%3Aclosed+reviewed-by%3Aasusteven+)

 Below I want links that I can click on to your commit or PullRequest with your work (not the branch you worked on). I also want a short description what this commit/PR is about (or test etc.)

  **Links to GitHub commits (not PR) with main code contribution (up to 5 links) - important in each Sprint:

> * [US1 Task4 Update image path to resolve bug preventing preferences from opening](https://github.com/amehlhase316/Schnapsidee-Fall23B/commit/44633a6117997b9992f65b77de7286b69b69df9b)
> * [US1 Task3 Remove Look and Feel section in the preferences dialog](https://github.com/amehlhase316/Schnapsidee-Fall23B/commit/4dca99170d6e175f038e5a98513c6d79fad2a9bf)
> * [US15 Task73 Create reverse engineering doc with UML class diagrams for Events:Panel,Dialog,Manager, and FileStorage](https://github.com/amehlhase316/Schnapsidee-Fall23B/commit/4e46cd8fcf6c7c91acf6911c695ddd883b2b9f92)
> * [Update branch names and commit message guidelines to add more detail around GitHub Workflow](https://github.com/amehlhase316/Schnapsidee-Fall23B/commit/b36cbf31fb19956b57eda24a5e1de36049fa1fb3)

  **GitHub links to your Pull Requests (up to 3 links) -- fill out starting Sprint 1:

> * [US1 preferences look and feel](https://github.com/amehlhase316/Schnapsidee-Fall23B/pull/20)
> * [Update CodeQuality with additional details for Github workflow](https://github.com/amehlhase316/Schnapsidee-Fall23B/pull/17)

   **GitHub links to your Unit Tests (up to 3 links) -- fill out starting Sprint 3 (everyone should write 4 good Unit Tests each Sprint):

    - link1
    - link2

  
  **GitHub links to your Code Reviews (up to 3 links) -- fill out starting Sprint 3:

    - link1
    - link2

  **How did you contribute to Static Analysis -- fill out starting Sprint 4:

    - link1
    - link2
 
#### Rhett Harrison

  **Do you think you individually worked consistently and put in enough work into the project (give a short answer). 
  > Yes, I worked hard on my own stories and helped others with theirs. I also kept other's work going by providing code reviews and merging pull requests.

 Below I want links that I can click on to your commit or PullRequest with your work (not the branch you worked on). I also want a short description what this commit/PR is about (or test etc.)

  Example: 
  [Commit 1](https://github.com/amehlhase316/memoranda/commit/b949872433ae07f723bebe13c916064d03ef8882) - Updated DeliverableX.md table to include who did not attend meetings

  **Links to GitHub commits (not PR) with main code contribution (up to 5 links) - important in each Sprint:

[Add new panel "Trainers"](https://github.com/amehlhase316/Schnapsidee-Fall23B/commit/335a6f30af22c9a5f236e0f8f0111c269098e527)

[Add translations from spanish to english for UX and Developer Experience](https://github.com/amehlhase316/Schnapsidee-Fall23B/commit/9d1e21cbd99971ae6c5ed2233650cfbd822b7840) 


  **GitHub links to your Pull Requests (up to 3 links) -- fill out starting Sprint 1:

  [Add new panel "Trainers"](https://github.com/amehlhase316/Schnapsidee-Fall23B/pull/18) 

  [Add Translations from spanish to english for UX and Developer Experience](https://github.com/amehlhase316/Schnapsidee-Fall23B/pull/6) 


   **GitHub links to your Unit Tests (up to 3 links) -- fill out starting Sprint 3 (everyone should write 4 good Unit Tests each Sprint):

    - link1
    - link2

  
  **GitHub links to your Code Reviews (up to 3 links) -- fill out starting Sprint 3:

    - link1
    - link2

  **How did you contribute to Static Analysis -- fill out starting Sprint 4:

    - link1
    - link2

#### Frank Lin

  **Do you think you individually worked consistently and put in enough work into the project (give a short answer). 

> I think I worked consistently and put in enough work into the project. I was able to complete my user stories and provide code reviews for other team members.

 Below I want links that I can click on to your commit or PullRequest with your work (not the branch you worked on). I also want a short description what this commit/PR is about (or test etc.)

  Example: 
  [Commit 1](https://github.com/amehlhase316/memoranda/commit/b949872433ae07f723bebe13c916064d03ef8882) - Updated DeliverableX.md table to include who did not attend meetings

  **Links to GitHub commits (not PR) with main code contribution (up to 5 links) - important in each Sprint:

  > - [Updates the splash screen and program title.](https://github.com/amehlhase316/Schnapsidee-Fall23B/commit/d2b30dc78564c4aaed98c707e171926eafdf861c)
  > - [Allows developers to update version and build number through `build.xml` and display the information in program.](https://github.com/amehlhase316/Schnapsidee-Fall23B/commit/9252343dae5eb30b3ea861ff2753c32c56c65177)

  **GitHub links to your Pull Requests (up to 3 links) -- fill out starting Sprint 1:

  > - [Updates the splash screen and program title.](https://github.com/amehlhase316/Schnapsidee-Fall23B/pull/13)
  > - [Allows developers to update version and build number through `build.xml` and display the information in program.](https://github.com/amehlhase316/Schnapsidee-Fall23B/pull/11)

   **GitHub links to your Unit Tests (up to 3 links) -- fill out starting Sprint 3 (everyone should write 4 good Unit Tests each Sprint):

    - link1
    - link2

  
  **GitHub links to your Code Reviews (up to 3 links) -- fill out starting Sprint 3:

    - link1
    - link2

  **How did you contribute to Static Analysis -- fill out starting Sprint 4:

    - link1
    - link2

#### Zachary Pangerl

  **Do you think you individually worked consistently and put in enough work into the project (give a short answer). 

> Yes, I think I worked consistently and provided enough work for the project. I would have liked to do more, but everything was either in progress or done by the time I had time to do more.

 Below I want links that I can click on to your commit or PullRequest with your work (not the branch you worked on). I also want a short description what this commit/PR is about (or test etc.)

  Example: 
  [Commit 1](https://github.com/amehlhase316/memoranda/commit/b949872433ae07f723bebe13c916064d03ef8882) - Updated DeliverableX.md table to include who did not attend meetings

  **Links to GitHub commits (not PR) with main code contribution (up to 5 links) - important in each Sprint:

  > - [Commit 1](https://github.com/amehlhase316/Schnapsidee-Fall23B/commit/10db97b2375fda7ff98e9e2e8ec34fdfa3e07b05) - Updated main folder to remove all deprecated Integer warnings
  > - [Commit 2](https://github.com/amehlhase316/Schnapsidee-Fall23B/commit/6f18d6cf86228daa3cbf3a83337d7369c76551a2) - Updated ui folder to remove all deprecated Integer warnings
  > - [Commit 3](https://github.com/amehlhase316/Schnapsidee-Fall23B/commit/f88249ade302d085dadfd5eb7fd4b89d6059abb8) - Updated htmleditor folder to remove all deprecated Integer warnings
  > - [Commit 4](https://github.com/amehlhase316/Schnapsidee-Fall23B/commit/c9ee8e14d74374facc01c6e1746c88f40346c6f4) - Updated remaining folders to remove all deprecated Integer warnings

  **GitHub links to your Pull Requests (up to 3 links) -- fill out starting Sprint 1:

  > - [Pull Request 1](https://github.com/amehlhase316/Schnapsidee-Fall23B/pull/14) - Updates dev branch with all changes from US19
  > - [Pull Request 2](https://github.com/amehlhase316/Schnapsidee-Fall23B/pull/9) - Updates US branch with updates to the ui folder removing deprecated Integer code

   **GitHub links to your Unit Tests (up to 3 links) -- fill out starting Sprint 3 (everyone should write 4 good Unit Tests each Sprint):

    - link1
    - link2

  
  **GitHub links to your Code Reviews (up to 3 links) -- fill out starting Sprint 3:

    - link1
    - link2

  **How did you contribute to Static Analysis -- fill out starting Sprint 4:

    - link1
    - link2

#### Sean Mckeighan

  **Do you think you individually worked consistently and put in enough work into the project (give a short answer). 

> I pulled my fair share of the user stories for this sprint. I started strong but slowed down toward the end of the sprint.

 Below I want links that I can click on to your commit or PullRequest with your work (not the branch you worked on). I also want a short description what this commit/PR is about (or test etc.)

  Example: 
  [Commit 1](https://github.com/amehlhase316/memoranda/commit/b949872433ae07f723bebe13c916064d03ef8882) - Updated DeliverableX.md table to include who did not attend meetings

  **Links to GitHub commits (not PR) with main code contribution (up to 5 links) - important in each Sprint:

  > - [US5 Panel Icons Commit](https://github.com/amehlhase316/Schnapsidee-Fall23B/commit/e994c678f9db637f23184edd1b59189949ad2312)
  > - [US11 Minimize & Exit Commit](https://github.com/amehlhase316/Schnapsidee-Fall23B/commit/4f08298069321a7217c635396b2cac0551381c1f)

  **GitHub links to your Pull Requests (up to 3 links) -- fill out starting Sprint 1:

  > - [US5 Panel Icon PR](https://github.com/amehlhase316/Schnapsidee-Fall23B/pull/23)
  > - [US11 Minimize & Exit PR](https://github.com/amehlhase316/Schnapsidee-Fall23B/pull/5)

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
- [x] Form above is complete
- [ ] Your newest software is on the master branch on GitHub, it is tested and compiles/runs
- [ ] This document is in your master branch on GitHub
- [ ] Read the kickoff again to make sure you have all the details that I want
- [ ] User Stories that were not completed, were left in the Sprint and a copy created to move to the next Sprint
- [x] Your Quality Policies are accurate and up to date
- [ ] **Individual** Survey was submitted **individually** (create checkboxes below -- see Canvas to get link)
  - [x] Rhett Harrison
  - [ ] Frank Lin
  - [x] Steven Stovall
  - [ ] Zachary Pangerl
  - [x] Sean Mckeighan

#### For the next Sprint
  - [ ] The original of this file was copied for the next Sprint (needed for all but last Sprint where you do not need to copy it anymore)
    - [ ] Basic information (part 1) for next Sprint was included in this new Deliverable document 
  - [ ] You added new User Stories to your Product Backlog, they are correctly written (needed after Sprint 1, 2)
  - [ ] All User Stories have acceptance tests
  - [ ] User Stories in your new Sprint Backlog have initial tasks which are in New column
  - [ ] You know how to proceed (if not please reach out)
