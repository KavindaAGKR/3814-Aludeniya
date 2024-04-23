
pipeline {
  agent any
  triggers{
    githubPush()
  }
  stages {
    stage('build'){
      steps {
        sh 'docker build -t 3814-dockerimage .'
      }
    }
    stage('run'){
      steps{
        sh 'docker run -d -p 5000:3000 3814-dockerimage'
      }
    }
    stage('status'){
      steps{
        sh 'docker ps'
      }
    }
  }
}
