import React from 'react'

const NewsItem = ({
  datetime,
  headline,
  source,
  url,
  summary
}) => {
  return (
    <div>
      <a href={url} target="_blank"> <h3>{ headline }</h3> </a>
      <div>
        Source: <em>{ source }</em>, { datetime.toString().substr(0,10) }
      </div>
      <div>
        <p>
          { summary }
        </p>
      </div>
    </div>
  )
}

export default NewsItem