tap = "click"
tap ="touchstart" if Modernizr.touch

$(document).on tap, '.brick.closed', (event) ->
  $this = $(this)
  $this.animate { 'width': '100%' }, 'fast', () ->
  $this.removeClass('closed')
  $this.addClass('open')

$(document).on tap, '.brick a.js-close', (event) ->
  $brick = $(this).closest('.brick')
  $brick.animate { 'width': '120px' }, 'fast', () ->
    $brick.removeClass('open')
    $brick.addClass('closed')

