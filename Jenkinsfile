pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                git branch: 'desa',
                    url: 'https://github.com/liopalacios/sb-security-base',
                    credentialsId: 'github-lio'
            }
        }
        stage('Build') {
            steps {
                echo "Compilando proyecto..."
            }
        }
    }
}