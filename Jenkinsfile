pipeline {
    agent any

    tools {
        gradle 'Gradle'
    }

    environment {
        SONARQUBE_ENV = 'sonarqube'
    }

    stages {
        stage('Init') {
            steps {
                echo '✅ Pipeline iniciado correctamente'
            }
        }
        stage('Checkout') {
            steps {
                git branch: 'desa', url: 'https://github.com/liopalacios/sb-security-base.git'
                echo '✅ Código descargado'
            }
        }
        stage('Test Gradle') {
            steps {
                sh 'gradle --version'
            }
        }
        stage('Build and Test') {
            steps {
                echo 'Simulación de build con Gradle'
            }
        }
    }
}
