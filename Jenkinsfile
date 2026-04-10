pipeline {
    agent any

    stages {
        stage('Checkout Code') {
            steps {
                echo '📦 Cloning repository from GitHub...'
                checkout scm
            }
        }

        stage('Check Java Version') {
            steps {
                echo '🔍 Checking Java version being used...'
                bat 'java -version'
            }
        }

        stage('Compile Code') {
            steps {
                echo '🔨 Compiling Java code with Maven using Java 22...'
                // IMPORTANT: Replace this path with YOUR Java 22 path from Step 4
                bat 'C:\Program Files\Java\jdk-21\bin\java.exe && mvn clean compile'
            }
        }

        stage('Run Unit Tests') {
            steps {
                echo '🧪 Running JUnit tests with Java 22...'
                // IMPORTANT: Replace this path with YOUR Java 22 path from Step 4
                bat 'C:\Program Files\Java\jdk-21\bin\java.exe && mvn test'
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
