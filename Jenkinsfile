pipeline {
    agent any

    stages {
        stage('Checkout Code') {
            steps {
                echo '📦 Cloning repository from GitHub...'
                checkout scm
            }
        }

        stage('Set Java 21 and Compile') {
            steps {
                echo '🔨 Setting JAVA_HOME to Java 21 and compiling...'
                bat '''
                    set JAVA_HOME=C:\\Program Files\\Java\\jdk-21
                    set PATH=%JAVA_HOME%\\bin;%PATH%
                    java -version
                    mvn clean compile
                '''
            }
        }

        stage('Run Unit Tests') {
            steps {
                echo '🧪 Running JUnit tests with Java 21...'
                bat '''
                    set JAVA_HOME=C:\\Program Files\\Java\\jdk-21
                    set PATH=%JAVA_HOME%\\bin;%PATH%
                    mvn test
                '''
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
