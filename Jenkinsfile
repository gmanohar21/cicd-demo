pipeline {
    agent any

    stages {
        stage('Clone Repository') {
            steps {
                git 'https://github.com/gmanohar21/cicd-demo.git'
            }
        }

        stage('Build with Gradle') {pipeline {
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

                                            stage('Push to Docker Hub') {
                                                steps {
                                                    withCredentials([usernamePassword(credentialsId: 'dockerhub-creds', usernameVariable: 'DOCKER_USER', passwordVariable: 'DOCKER_PASS')]) {
                                                        bat """
                                                            docker login -u %DOCKER_USER% -p %DOCKER_PASS%
                                                            docker tag cicd-demo-app %DOCKER_USER%/cicd-demo-app:latest
                                                            docker push %DOCKER_USER%/cicd-demo-app:latest
                                                        """
                                                    }
                                                }
                                            }

                                            stage('Deploy to Kubernetes') {
                                                steps {
                                                    bat """
                                                        kubectl set image deployment/cicd-demo-app cicd-demo-app=%DOCKER_USER%/cicd-demo-app:latest --record
                                                        kubectl rollout status deployment/cicd-demo-app
                                                    """
                                                }
                                            }
                                        }
                                    }

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
