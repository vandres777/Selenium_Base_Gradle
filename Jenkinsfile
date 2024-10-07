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
        stage('Install Chrome and ChromeDriver') {
            steps {
                sh '''
                    # Install Chrome
                    wget -q -O - https://dl.google.com/linux/linux_signing_key.pub | sudo apt-key add -
                    sudo sh -c 'echo "deb [arch=amd64] http://dl.google.com/linux/chrome/deb/ stable main" >> /etc/apt/sources.list.d/google-chrome.list'
                    sudo apt-get update
                    sudo apt-get install -y google-chrome-stable

                    # Install ChromeDriver
                    CHROME_DRIVER_VERSION=`curl -sS chromedriver.storage.googleapis.com/LATEST_RELEASE`
                    wget -N https://chromedriver.storage.googleapis.com/$CHROME_DRIVER_VERSION/chromedriver_linux64.zip
                    unzip chromedriver_linux64.zip
                    sudo mv -f chromedriver /usr/local/bin/chromedriver
                    sudo chmod 0755 /usr/local/bin/chromedriver
                '''
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