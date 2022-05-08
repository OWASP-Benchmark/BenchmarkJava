class ApplicationController < ActionController::Base
protect_from_forgery with: :exception
end
class UsersController < ApplicationController
def update
con = Mysql.new 'localhost', 'user', 'pwd'
con.query 'UPDATE users set name = ' + params[:name] +
' where id = ' + params[:id]
con.close
end
end
