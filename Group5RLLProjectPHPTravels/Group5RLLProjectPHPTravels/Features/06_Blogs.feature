Feature: Click BlogsPage

@TS_06
Scenario: A user must be able to select the BlogPage on Blogs
	Given a user is on landing page
		When he clicks on Blogs in the navigator bar
		And he clicks on BlogsPage in the Blogs
		Then he must be able to select the blogspage sucessfully.