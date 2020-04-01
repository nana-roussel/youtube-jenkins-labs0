pipeline {
    agent any 
    tools {
        maven 'maven363' 
    }
    stages {
        stage('Echo') {
            steps {
                echo "Le step de test"
                sh 'mvn --version'
            }
        }
         stage('Unit test') {
             steps {
                sh 'mvn test'
            }
         }
         stage('Package') {
             steps {
                sh 'mvn package -DskipTest'
            }
         }         
    }
}