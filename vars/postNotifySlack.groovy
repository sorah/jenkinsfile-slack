def call(String buildStatus) {

  def color = '#e3e4e6'
  def statusMessage = buildStatus ?: 'SUCCESS'

  if (buildStatus == 'STARTED') {
    color = '#e3e4e6'
    statusMessage = 'Started'
  }
  if (buildStatus == 'SUCCESS') {
    color = 'good'
    statusMessage = 'Success'
  }
  if (buildStatus == 'FAILURE') {
    color = 'danger'
    statusMessage = 'FAILURE'
  }
  if (buildStatus == 'ABORTED') {
    color = 'warning'
    statusMessage = 'Aborted'
  }
  if (buildStatus == 'NOT_BUILT') {
    color = 'warning'
    statusMessage = 'Not built'
  }
  if (buildStatus == 'UNSTABLE') {
    color = 'danger'
    statusMessage = 'Unstable'
  }

  def message = "${env.JOB_NAME} <${env.BUILD_URL}|#${env.BUILD_NUMBER}> *${statusMessage}* "

  slackSend (color: color, message: message)
}
