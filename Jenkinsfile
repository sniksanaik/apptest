pipeline {
    agent any

    tools {
        // Use the Maven and JDK tools configured in Jenkins
        maven 'Maven 3.8.4'
        jdk 'JDK 21'
    }

    stages {
        stage('Checkout') {
            steps {
                // Clone the repository to the Jenkins workspace
                git 'https://github.com/your-repo/selenium-project.git'
            }
        }

        stage('Build') {
            steps {
                // Compile and build the project using Maven
                sh 'mvn clean compile'
            }
        }

        stage('Run Tests') {
            steps {
                // Run the Selenium tests
                sh 'mvn test'
            }
        }

        stage('Post-Build') {
            steps {
                // Optional: Archive the test results and artifacts
                archiveArtifacts artifacts: '**/target/*.jar', allowEmptyArchive: true
                junit 'target/surefire-reports/*.xml'
            }
        }
    }

    post {
        always {
            echo 'Pipeline execution completed.'
        }
        success {
            echo 'Build succeeded!'
        }
        failure {
            echo 'Build failed!'
        }
    }
}
