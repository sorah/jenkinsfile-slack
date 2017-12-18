def call(build) {
  buildStatus = build.result

  def color = '#e3e4e6'
  def statusMessage = buildStatus

  if (buildStatus == 'STARTED') {
    color = '#e3e4e6'
    statusMessage = 'Started'
  }
  if (buildStatus == 'SUCCESS') {
    color = 'good'
    statusMessage = 'Success'
  }
  if (status == 'FAILURE') {
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
  if (status == 'UNSTABLE') {
    color = 'danger'
    statusMessage = 'Unstable'
  }

  def message = "${env.JOB_NAME} #${env.BUILD_NUMBER}: *${statusMessage}* <Open|${env.BUILD_URL}>"

  slackSend (color: color, message: message)
}
