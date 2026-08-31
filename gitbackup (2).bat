@echo off

echo what do you want to do?
echo 1. Init Git and upload to github
echo 2. Backup an existing project to github
echo 3. Download a project from github
echo 4. Sync your project with github
echo 5. Init a local git repo (doesnt get uploaded to github)
echo 6. Make a commit (local)
echo 7. install github cli
echo 8. Authenticate with github cli

echo NOTE: Please make sure that you run this script in the root directory of your project. If you run it in a subdirectory or outside the project directory, it will not work.

set /p choice="Enter your choice (1-8): "

IF "%choice%"=="1" (
    git init
    git add .
    git commit -m "Initial commit"

    echo WARNING: Please make sure your Project is less then 2gb!

    set /p does="does this repo exist on github and is the owner authenticated on this pc? (y/n): "
    IF /i "%does%"=="y" (
        set /p user_name="Enter your GitHub username: "
        set /p repo_name="Enter the repository name: "

        git remote add origin https://github.com/%user_name%/%repo_name%.git
        git push -u origin main

    ) ELSE IF /i "%does%"=="n" (
        echo Please login to GitHub using github cli and create the repo on github.com before proceeding.
        exit
    )
        
) ELSE IF "%choice%"=="2" (
    git add .
    git commit -m "push to github"

    echo WARNING: Please make sure your Project is less then 2gb!
    pause

    set /p does="does this repo exist on github and is the owner authenticated on this pc? (y/n): "
    IF /i "%does%"=="y" (
        set /p user_name="Enter your GitHub username: "
        set /p repo_name="Enter the repository name: "

        git remote add origin https://github.com/%user_name%/%repo_name%.git
        git push -u origin main

    ) ELSE IF /i "%does%"=="n" (
        echo Please login to GitHub using github cli and create the repo on github.com before proceeding.
        exit
    )
    
) ELSE IF "%choice%"=="3" (

    set /p user_name="Enter GitHub username of the repository owner: "
    set /p repo_name="Enter the repository name: "

    git clone https://github.com/%user_name%/%repo_name%.git
    
) ELSE IF "%choice%"=="4" (

    set /p upvsdown="Do you want to upload to github or download from github? (u/d): "

    IF /i "%upvsdown%"=="u" (
        git add .
        set /p commit_message="Enter your commit message: "
        git commit -m %commit_message%
        git push
    ) ELSE IF /i "%upvsdown%"=="d" (
        git pull
    ) ELSE (
        echo Invalid choice. Please run the script again and select a valid option.
    )
    
) ELSE IF "%choice%"=="5" (
    git init
) ELSE IF "%choice%"=="6" (
    git add .
    set /p commit_message="Enter your commit message: "
    git commit -m %commit_message%
) ELSE IF "%choice%"=="7" (
    echo Installing GitHub CLI...
    winget install -e --id GitHub.cli
) ELSE IF "%choice%"=="8" (
    echo Authenticating with GitHub CLI...
    gh auth login
) ELSE (
    echo Invalid choice. Please run the script again and select a valid option.
)