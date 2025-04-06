pipeline {
    agent any
    
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
