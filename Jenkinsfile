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
        stage('Build') {
            steps {
                sh './gradlew clean build'
            }
        }
        stage('Test') {
            steps {
                sh './gradlew test aggregate'
            }
        }
        stage('Archive Reports') {
            steps {
                publishHTML(target: [
                    reportDir: 'build/reports/tests/test',
                    reportFiles: 'index.html',
                    reportName: 'Serenity BDD Report'
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