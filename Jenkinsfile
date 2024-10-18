pipeline {
    agent any
    environment {
        DOCKER_IMAGE = 'kepler:latest'
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
                    docker build -f ./docker/basic-initialization/Dockerfile -t ${DOCKER_IMAGE} .
                    """
                }
            }
        }

        stage('Run Docker Container') {
            steps {
                script {
                    def myEnvVar = credentials('KEPLER_-_')
                    sh "docker stop kepler || true"
                    sh "docker rm kepler || true"
                    sh """
                        docker run -d --restart=always --name kepler -p 4000:8080 --env-file /opt/kepler/.env ${DOCKER_IMAGE}
                    """
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
