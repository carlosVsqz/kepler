pipeline {
    agent any
    stages {
        stage('Checkout') {
            steps {
                checkout scm
            }
        }

        stage('Setup Docker Environment') {
            steps {
                script {
                    def dockerEnv = sh(script: 'minikube docker-env', returnStdout: true).trim()
                    echo "Docker environment: ${dockerEnv}"
                    sh "eval ${dockerEnv}"
                }
            }
        }

        stage('Build Docker Image') {
            steps {
                script {
                    sh """
                    docker build -f ./docker/basic-initialization/Dockerfile -t kepler:latest .
                    """
                }
            }
        }

        stage('Deploy to Kubernetes') {
            steps {
                script {
                    sh 'kubectl apply -f ./k8s/deployment.yaml'
                    sh 'kubectl apply -f ./k8s/service.yaml'
                }
            }
        }
    }
    post {
        always {
            echo 'Pipeline complete.'
        }
    }
}
