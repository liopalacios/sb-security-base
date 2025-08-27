pipeline{
    agent any
    stages{
        stage('Prueba'){
            steps{
                bat 'echo "✅ Jenkinsfile detectado y ejecutándose en branch desa"'
            }
        }
    }
}
post{
    success{
        bat 'echo "buil successfull"'
    }
    failure{
        bat 'echo "buil error"'
    }
}
