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
        }   
        
         stage('Package') {
             steps {
                sh 'mvn package -DskipTest'
            }
         }  
        stage('Build and Run docker image') {
             steps {
                sh "docker build -t freemanpolys/test:v1.0.${BUILD_NUMBER} ."
                script {
                    try {
                        sh 'docker rm -f test'
                    }catch (exc) {
                        echo 'Erreur de suppression'
                    }
                }
                sh "docker run --name test -d -p 8088:8088 freemanpolys/test:v1.0.${BUILD_NUMBER}"
            }
         }         
         stage('Push docker image') {
             steps {
                      withCredentials([usernamePassword(passwordVariable : 'DOCKER_PASSWORD' ,usernameVariable : 'DOCKER_USERNAME' ,credentialsId : "dockerhub" ,)]) {
                        sh 'echo "$DOCKER_PASSWORD" | docker login docker.io -u "$DOCKER_USERNAME" --password-stdin'
                        sh 'docker push  freemanpolys/test:v1.0.${BUILD_NUMBER}'
                    }
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
