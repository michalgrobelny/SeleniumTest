pipeline {
    agent any

    tools {
        jdk 'jdk-17'             // Match the name set in Jenkins tools
        maven 'maven-3.8.6'      // Match the name set in Jenkins tools
    }

    stages {
        stage('Build') {
            steps {
                sh 'mvn clean compile'
            }
        }

        stage('Run Selenium Test') {
            steps {
                sh 'mvn exec:java'
            }
        }

        stage('Archive Screenshot') {
            steps {
                archiveArtifacts artifacts: 'screenshot.png', fingerprint: true
            }
        }
    }
}
