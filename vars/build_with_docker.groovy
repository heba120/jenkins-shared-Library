def call (String tag= "shared_jenkinsaws:latest") {
  DOCKER_IMAGE_NAME = tag
  withCredentials([usernamePassword(credentialsId: 'dockerhub', usernameVariable: 'USERNAME', passwordVariable: 'PASSWORD')]) {
                        // Build the Docker image
                        sh "docker build -t ${DOCKER_IMAGE_NAME} -f dockerfile ."
    
                        // Log in to Docker Hub
                        sh "docker login -u ${USERNAME} -p ${PASSWORD}"
    
                        // Push the Docker image to Docker Hub
                        sh "docker push ${DOCKER_IMAGE_NAME}" 
}
