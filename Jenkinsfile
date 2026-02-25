pipeline {
    agent any
    tools{
        maven 'Maven3'
        }

        stages {
            stage('check') {
                steps {
                 git 'https://github.com/hyoneekim/spring26_SEP1_assignments.git'
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

    }