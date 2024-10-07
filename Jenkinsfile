pipeline {
    agent any

    environment {
        JAVA_HOME = tool name: 'OpenJDK', type: 'jdk'
        PATH = "${env.JAVA_HOME}/bin:${env.PATH}"
    }

    tools {
        gradle 'Gradle'
    }

    stages {
        stage('Checkout') {
            steps {
                checkout scm
            }
        }
        stage('Verify Chrome and ChromeDriver Installation') {
            steps {
                sh '''
                    google-chrome --version
                    chromedriver --version
                '''
            }
        }
        stage('Grant execute permission for gradlew') {
            steps {
                sh 'chmod +x ./gradlew'
            }
        }
        stage('Build') {
            steps {
                sh './gradlew clean build'
            }
        }
        stage('Test') {
            steps {
                sh './gradlew test'
            }
        }
        stage('Archive Reports') {
            steps {
                publishHTML(target: [
                    reportDir: 'build/reports/tests/test',
                    reportFiles: 'index.html',
                    reportName: 'Test Report'
                ])
            }
        }
    }
    post {
        always {
            archiveArtifacts artifacts: 'build/reports/**/*.*', allowEmptyArchive: true
            junit 'build/test-results/**/*.xml'
        }
    }
}