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
            sh "mvn sonar:sonar -Dsonar.projectKey=simple-web-app -Dsonar.host.url=http://sonarqube:9000 -Dsonar.login=320c5903a0531a59a9b1699b2b3c48446d88a6ca"
          }
        }
        stage('Deliver') {
            steps {
                sh './jenkins/scripts/deliver.sh'
            }
        }
    }
}
