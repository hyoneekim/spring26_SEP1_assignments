pipeline {
    agent any

    environment {
        PATH = "/opt/homebrew/bin:/usr/local/bin:${env.PATH}"
        DOCKERHUB_REPO = 'hyoneekim/opt1'
        DOCKER_IMAGE_TAG = "latest"
        DOCKERHUB_CREDENTIALS_ID = 'docker_hub'
    }

    stages {
    stage('check') {
                        steps {
                        git branch: 'main',
                         url: 'https://github.com/hyoneekim/spring26_SEP1_assignments.git'
                        }
                }
                    stage('build') {
                        steps {
                         sh 'mvn install'
                        }
                }
                    stage('report') {
                        steps {
                        sh 'mvn jacoco:report'

                        }
                }
        stage('Publish Test Results') {
                    steps {
                        junit '**/target/surefire-reports/*.xml'
                    }
                }
                stage('Publish Coverage Report') {
                    steps {
                        jacoco()
                    }
                }
                stage('Build Docker image'){
                steps {
                  script {
                      sh '''
                      docker build --platform linux/amd64,linux/arm64 -t ${DOCKERHUB_REPO}:${DOCKER_IMAGE_TAG}
                      '''
                  }
                }

                }

        stage('Push Docker Image') {
            steps {
                withCredentials([usernamePassword(
                    credentialsId: "${DOCKERHUB_CREDENTIALS_ID}",
                    usernameVariable: 'DOCKER_USER',
                    passwordVariable: 'DOCKER_PASS'
                )]) {
                    sh '''
                        echo $DOCKER_PASS | docker login -u $DOCKER_USER --password-stdin
                        docker push ${DOCKERHUB_REPO}:${DOCKER_IMAGE_TAG}
                    '''
                }
            }
        }
    }
}