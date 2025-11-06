pipeline {
    agent any

    stages {
        stage('Clone Repository') {
            steps {
                git 'https://github.com/gmanohar21/cicd-demo.git'
            }
        }

        stage('Build with Gradle') {
            steps {
                bat 'gradlew clean build'
            }
        }

        stage('Build Docker Image') {
            steps {
                bat 'docker build -t cicd-demo-app .'
            }
        }

        stage('Run Docker Container') {
            steps {
                bat 'docker run -d -p 8080:8080 cicd-demo-app'
            }
        }
    }
}
