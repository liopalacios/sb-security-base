pipeline {
    agent any

    tools {
        gradle 'Gradle' // Configura Gradle en Jenkins (Manage Jenkins > Global Tool Configuration)
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
                // sh './gradlew clean build'
            }
        }

        /*stage('SonarQube Analysis') {
            steps {
                withSonarQubeEnv("${SONARQUBE_ENV}") {
                    sh './gradlew sonarqube -Dsonar.projectKey=sb-security-base'
                }
            }
        }

        stage('Build Docker Image') {
            steps {
                sh 'docker build -t sb-security-base:latest .'
            }
        }*/
    }
}
