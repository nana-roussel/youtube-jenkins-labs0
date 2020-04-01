pipeline {
    agent any 
    tools {
        maven 'maven363' 
    }
    stages {
        stage ('Unit test') {
            steps {
                sh 'mvn test'
            }
            post {
                always {
                    junit 'target/surefire-reports/**/*.xml'
                }
            }
        
        }   
        
         stage('Package') {
             steps {
                sh 'mvn package -DskipTest'
            }
            post {
                always {
                    archiveArtifacts artifacts: 'target/*.jar'
            }
         }         
    }
}