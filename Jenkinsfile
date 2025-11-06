pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                git 'https://github.com/gmanohar21/cicd-demo.git'
            }
        }

        stage('Build with Gradle') {
            steps {
                sh './gradlew clean build'
            }
        }

        stage('Docker Build & Push') {
            steps {
                sh 'docker build -t cicd-demo:latest .'
                // optional: push to Docker Hub
                // sh 'docker tag cicd-demo:latest yourdockerhubusername/cicd-demo:latest'
                // sh 'docker push yourdockerhubusername/cicd-demo:latest'
            }
        }

        stage('Deploy to Kubernetes') {
            steps {
                sh 'kubectl apply -f kubernetes/deployment.yaml'
                sh 'kubectl apply -f kubernetes/service.yaml'
            }
        }
    }
}
