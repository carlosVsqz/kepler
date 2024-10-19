pipeline {
    agent any
    environment {
        DOCKER_IMAGE = 'kepler:latest'
        DOCKER_VOLUME = 'kepler_data'
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

        stage('Create or Use Docker Volume') {
            steps {
                script {
                    sh """
                    docker volume inspect ${DOCKER_VOLUME} >/dev/null 2>&1 || docker volume create --name ${DOCKER_VOLUME}
                    """
                }
            }
        }

        stage('Run Docker Container') {
            steps {
                script {
                    sh "docker stop kepler || true"
                    sh "docker rm kepler || true"
                    sh """
                        docker run -d --restart=always --name kepler -p 4000:8080 \
                        --env-file /opt/kepler/.env \
                        -v ${DOCKER_VOLUME}:/path/to/data \
                        ${DOCKER_IMAGE}
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
