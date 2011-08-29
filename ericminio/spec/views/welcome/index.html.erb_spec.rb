require 'spec_helper'

describe "welcome/index.html.erb" do

  before(:each) do
    render
  end

  it "has a board container" do
    rendered.should have_selector('#board')
  end

  it "has a status container" do
    rendered.should have_selector('#status')
  end

end