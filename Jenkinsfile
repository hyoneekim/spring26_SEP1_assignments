    pipeline {
        agent any
        tools{
            maven '3.9.12'
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

    }
            }

