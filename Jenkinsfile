pipeline {
    agent any
    tools {
        maven 'maven'
    }
    stages {
        stage('Build') {
          steps {
            // Run the maven build
            sh "mvn clean verify"
          }
          post {
              always {
                  junit 'target/surefire-reports/*.xml'
                  archiveArtifacts 'target/surefire-reports/*.xml'
              }
          }
        }
        stage('Sonarqube') {
          steps {
            sh "mvn sonar:sonar -Dsonar.projectKey=simple-web-app -Dsonar.host.url=http://sonarqube:9000 -Dsonar.login=321cdc3630597a63ea91c8c88bbfc3c88330c3dc"
          }
        }
        stage('Deliver') {
            steps {
                sh './jenkins/scripts/deliver.sh'
            }
        }
    }
}
