    pipeline {
        agent any
        tools{
            maven '3.9.12'
            }
        environment {
              PATH = "/opt/homebrew/bin:/usr/local/bin:${env.PATH}"
              DOCKERHUB_CREDENTIALS_ID = 'docker_hub'
              DOCKERHUB_REPO = "hyoneekim/trusting_cray"
              DOCKER_IMAGE_TAG = 'latest'
          }

            stages {
                stage('check') {
                    steps {
                    git branch: 'main',
                     url: 'https://github.com/hyoneekim/spring26_SEP1_assignments.git',
                     credentialsId: 'hyoneekim'
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
                  docker.build("${DOCKERHUB_REPO}:${DOCKER_IMAGE_TAG}")
              }
            }

            }
            stage('Push Docker Image to Dock Hub'){
            steps{
              script {
                  docker.withRegistry('https://index.docker.io/v1/', DOCKERHUB_CREDENTIALS_ID) {
                      docker.image("${DOCKERHUB_REPO}:${DOCKER_IMAGE_TAG}").push()
                  }
            }
            }

    }
            }

