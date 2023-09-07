1. Jenkins WAR download
   https://jenkins.io/download/

2. Run the Jenkins WAR file
   java -jar Jenkins.war

3. Get the admin password from
   /Users/duttas/.jenkins/secrets/initialAdminPassword

4. Jenkins initial setup wizard will require the password and additional setup information

5. Create Jenkins Credential for GIT
   Go to Jenkins Credential > Select Jenkins scope > Global Credential >
   Add Credentials

6. Create a Job and Configure with GIT details

7. Add Parameters to execute mvn project with params
   Choose option — This project is parameterized

8. Now add docker compose file
9. Run command
   docker-compose -f docker_compose_vnc.yml up

10. Get vnc viewer running
    Get the port number using docker ps -a
    127.0.0.1:32769

11. Shutdown jenkins with following command
    sudo java -jar jenkins-cli.jar -s http://localhost:8080/ -auth souvik:souvik shutdown

12: Docker stop container
docker stop $(docker ps -a -q)
docker system prune

docker system prune —volumes

13. Run Jenkins in docker container and get the Jenkins password from the container

TO WORK INSIDE THE DOCKER CONTAINER
docker exec -it docker_jenkins_1 /bin/bash ==> enables to open the bash inside the container

navigate to
/bitnami/jenkins/jenkins_home/users/user_1187227223682999397 and cat config.xml to get the password

14. cat > config.xml to replace the config.xml with new password coming from https://www.browserling.com/tools/bcrypt

Replace the new password here
<passwordHash>#jbcrypt:$2a$10$9NOuDamzx2edg4gqab8b6erCaAKnQNCuzoO2V3cUO.44jFtv5B1e6</passwordHash>

15.
docker-remove-all-images-and-containers.sh📋 Copy to clipboard⇓ Download
docker rm $(docker ps -a -q)
docker rmi $(docker images -q)
This solution has be proposed by GitHub user @crosbymichael in this issue

In case you want to delete even those images that are referenced in repositories, use

docker-remove-all-images-and-containers.sh📋 Copy to clipboard⇓ Download



Docker compose up
Docker-compose up —build

16: find directory
find / -type d -name "*farm-animal-type*”

Docker Inspect
docker inspect <docker id>

For scaling

docker-compose up --scale chrome=3

Docker commands
1. Docker stop and remove container
   docker stop $(docker ps -a -q)
   docker rm $(docker ps -a -q)
   docker rmi $(docker images -a -q)


2. Docker compose selenium

version: ‘2.2’
services:
jenkins:
image: 'bitnami/jenkins:2’
ports:
- '80:8080’
- '443:8443’
- '50000:50000’
volumes:
- 'jenkins_data:/bitnami/jenkins’
selenium-hub:
restart: always
image: selenium/hub:latest
ports:
- "4444:4444”
#selenium-chrome
selenium-chrome:
restart: always
image: selenium/node-chrome-debug:latest
ports:
- 5900
links:
- selenium-hub:hub
#selenium-firefox
selenium-firefox:
restart: always
image: selenium/node-firefox-debug:latest
ports:
- 5900
links:
- selenium-hub:hub
volumes:
jenkins_data:
driver: local

GRID Setup
java -jar selenium-remote-driver-3.141.59.jar -role hub
java -jar selenium-server-standalone.jar -role node -hub http://localhost:4444


DOCKER
docker run -d -p 4446:4444 --name selenium-hub -P selenium/hub
docker run -d --link selenium-hub:hub  selenium/node-chrome-debug
docker run -d --link selenium-hub:hub  selenium/node-firefox-debug

- DOCKER IP ADDRESS
  sudo docker inspect container_id

DOCKER commands
docker ps - list images
docker run —help
docker logs container_id
https://docs.docker.com/engine/reference/commandline/container_ls/