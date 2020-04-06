pipeline {
    agent { label 'maven' } 
    tools {
        maven 'maven363' 
    }
    stages {
        stage ('Unit test') {
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

    post {
        always {
            junit 'target/surefire-reports/**/*.xml'
            archiveArtifacts artifacts: 'target/*.jar'
        }
    }
}
