pipeline {
    agent any 
    tools {
        maven 'maven363' 
    }
    stages {
        stage('Unit test') {
            steps {
                echo "Le step de test"
                sh 'mvn --version'
                sh 'mvn test'
            }
        }
    }
}