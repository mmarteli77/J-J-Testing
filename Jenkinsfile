node() {

def repoURL = 'https://github.com/mmarteli77/J-J-Testing.git'

stage("Prepare Workspace") {
    cleanWs()
    env.WORKSPACE_LOCAL = sh(returnStdout: true, script: 'pwd').trim()
    env.BUILD_TIME = sh(returnStdout: true, script: 'date +%F-%T').trim()
    echo "Workspaceset to:" + env.WORKSPACE_LOCAL
    echo "Build time" + env.BUILD_TIME
}

stage("Checkout Self"){
    git branch: 'master_automation', credentialsId: '', url: repoURL
}

stage('Cucumber Tests'){
    withMaven(maven: 'maven_3_5_0'){
       
      cd ${env.WORKSPACE_LOCAL}
      mvn clear test
}
}

stage('Export report'){
    archive "**/jsonReport.json"
    cucumber '**/jsonReport.json'
}


stage('Import results to Xray') {

def description = "[BUILD_URL|${env.BUILD_URL}]"
def labels = '["automation","test"]'
def environment = "QA"
def testExecutionFieldId = 4656268
def testEnvironmentFieldName = "customfield_NUMBER"
def projectKey = "KEY"
def xrayConnectorId = 'ID'
def info = '''{
         "fields": {
            "project": {
            "key": "''' + projectKey + '''"
          },
          "labels":''' + labels + ''',
          "description":"''' + description + '''",
          "summary": "Automated Regression Execution @ ''' + env.BUILD_TIME + ' ' + environment + '''",
          "issuetype": {
          "id": "''' + testExecutionFieldId + '''"
          },
          "''' + testEnvironmentFieldName + '''" : [
          "''' + environment + '''"
          ]

}

}'''

echo info

step([$class: 'XrayImportBuilder', endpointName: '/cucumber/multipart', importFilePath: 'Reports\\JSON', importInParallel: 'false', inputInfoSwitcher: 'fileContent', serverInstance: 'SERVER-68edb6d7-c5f6-43c2-9e3a-656aac56b587'])


}
}