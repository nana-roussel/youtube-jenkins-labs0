pipeline {
    agent any 
    tools {
        maven 'maven363' 
    }
    stages {
        stage ('Unit test') {
            steps {
                sh 'mvn test'
                junit 'reports/**/*.xml'
            }
        
        }   
        
         stage('Package') {
             steps {
                sh 'mvn package -DskipTest'
            }
         }         
    }
}