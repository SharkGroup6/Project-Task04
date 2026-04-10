pipeline {
    agent any

    stages {
        stage('Checkout Code') {
            steps {
                echo '📦 Cloning repository from GitHub...'
                checkout scm
            }
        }

        stage('Compile Code') {
            steps {
                echo '🔨 Compiling Java code with Maven...'
                bat 'mvn clean compile'
            }
        }

        stage('Run Unit Tests') {
            steps {
                echo '🧪 Running JUnit tests...'
                bat 'mvn test'
            }
            post {
                always {
                    echo '📊 Publishing test results...'
                    junit '**/target/surefire-reports/*.xml'
                }
            }
        }
    }

    post {
        success {
            echo '✅ Build completed successfully! All tests passed.'
        }
        failure {
            echo '❌ Build failed! Check the console output for errors.'
        }
    }
}
