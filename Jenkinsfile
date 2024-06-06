pipeline {
    agent any
    tools {
        maven 'M3'
        jdk 'JDK'
    }
    stages {
        stage('Initialize') {
            steps {
                sh '''
                    echo "PATH = ${PATH}"
                    echo "M2_HOME = ${M2_HOME}"
                '''
            }
        }
        stage('Build') {
            steps {
                echo 'This is a minimal pipeline.'
                sh 'mvn -B -DskipTests clean package'
            }
        }
        /*stage('Test') {
            steps { sh 'mvn test'}
            post {
                always {
                    junit 'target/surefire-reports/*.xml'
                }
            }
        }*/
    }
}