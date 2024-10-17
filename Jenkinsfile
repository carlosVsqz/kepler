pipeline {
    agent any
    environment {
        DOCKER_ENV = sh(script: 'minikube docker-env').trim()
    }
    stages {
        stage('Checkout') {
            steps {
                checkout scm
            }
        }

        stage('Build Docker Image') {
            steps {
                script {
                    sh """
                    eval \$(minikube docker-env) && docker build -f ./docker/basic-initialization/Dockerfile -t kepler:latest .
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
